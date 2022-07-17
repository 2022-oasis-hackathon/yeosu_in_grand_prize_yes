import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ImageUpload {
    public ArrayList<String> saveImage(HttpServletRequest request, String path) throws ServletException, IOException {
    	System.out.println("이미지 저장 시작");
        ArrayList<String> imgs = new ArrayList<>();
        //쓰는 경로는 매핑안됨 무조건 진짜 경로로 해야함
        String savePath = "/usr/local/tomcat/upload/"+path;
        String contentType = request.getContentType();

        //form 의 enctype이 multipart인지 검사
        if (contentType != null &&  contentType.toLowerCase().startsWith("multipart/")) {
            // getParts()를 통해 Body에 넘어온 데이터들을 각각의  Part로 쪼개어 리턴
            Collection<Part> parts = request.getParts();

            for (Part part : parts) {
                //해당 part가 파일인지 검사
                if  (part.getHeader("Content-Disposition").contains("filename=")) {
                    //업로드 할 파일명을 추출
                    String fileName =  extractFileName(part.getHeader("Content-Disposition"));
                    if (part.getSize() > 0) {
                        //파일명이 겹치지 않게 파일명에 랜덤 문자를 붙임
                        fileName = randomString() + fileName;
                        //파일 쓰기
                        part.write(savePath + File.separator + fileName);
                        //파일 이름(+경로)을 리스트에 저장
                        imgs.add("/upload/"+path+"/"+ fileName);

                        part.delete();
                    }
                } else {
                    //파일이 아닐경우 혹시 필요할까 남겨놓았음

                    continue;
                }
            }
            //업로드가 최종 완료되는 부분
            System.out.println(imgs.toString());
        }
        return imgs;
    }

    //후에 유지보수를 하게 된다면..sns회원가입에 랜덤문자생성해서 비밀번호로 대체하는 부분에서 쓸 수 있도록 해봐도 좋을듯
    private String randomString(){
        String str = "";
        str += System.currentTimeMillis();
        str += (char)((int)(Math.random()*26)+65);
        str += (char)((int)(Math.random()*26)+97);

        return str;
    }

    private String extractFileName(String partHeader) {
        for (String cd : partHeader.split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf("=") +  1).trim().replace("\"", "");;
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }
        return null;
    }
}
