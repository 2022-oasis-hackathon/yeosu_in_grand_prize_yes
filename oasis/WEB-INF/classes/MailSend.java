import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CertifiedDAO;

@WebServlet("/mailSend")
public class MailSend extends HttpServlet{
 
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail은 true 고정
        p.put("mail.smtp.host", "smtp.naver.com");      // smtp 서버 주소
        p.put("mail.smtp.auth","true");                 // gmail은 true 고정
        p.put("mail.smtp.port", "587");                 // 네이버 포트
           
        Authenticator auth = new SMTPAuthenticatior();
        //session 생성 및  MimeMessage생성
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
        
        String email = request.getParameter("email");
        String num = String.format("%04d", new Random().nextInt(10000));
        
        try{
        	
        	CertifiedDAO dao = new CertifiedDAO();
        	
        	dao.deleteCertified(response, email);
        	dao.insertCertified(response, email, num);
        	
        	PrintWriter out = response.getWriter();
        	
            //편지보낸시간
            msg.setSentDate(new Date());
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress("qofidgus123@naver.com"); //발신자 아이디
            // 이메일 발신자
            msg.setFrom(from);
            // 이메일 수신자
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);
            // 이메일 제목
            msg.setSubject("[당장]이메일 인증번호 발송메일", "UTF-8");
            // 이메일 내용
            msg.setText("\"" +email+ "\"에 대한 인증 요청되었습니다.<br> \n 아래 인증 코드를 입력해주세요.<br> 인증코드: \n" +
            num + "\n\n<br><br>만약 사용자가 인증 요청하지 않은 요청이라면 \"posin2361@naver.com\"으로 문의 바랍니다. <br><br>\n\n \"당장\""
            		+ " 어플리케이션팀", "UTF-8");
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");
            //메일보내기
            Transport.send(msg, msg.getAllRecipients());

            out.print(num);
            
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
        }catch (Exception msg_e) {
            msg_e.printStackTrace();
        }
	}
	
}