package restapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;





@Path("/create")
public class Test {
	@Path("/1")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public model.Result test(model.User user){
		model.Result re=new model.Result();
		int result;
		result= biz.User.Save(user);
		re.setStatus(result);
		return re;
		
	}

	@Path("/3/{username}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public model.Result test(model.Address address,@PathParam("username") String user){
		model.Result res=new model.Result();
		res.setStatus(biz.Address.sendAddress(address, user));
		 return res;
		
	}
	//----------@FormParam example
	@POST
	@Path("/2")
	
	public String test(@FormParam("name") String name,@FormParam("age") int age){
		
	   return "Name and age is added"+"Name= "+name+ "and Age"+age;
		
	}
	
	//----------Download the file example
	
	@GET
	@Path("/4")
	@Produces("application/pdf")
	 public Response getFile() {
	   File file=new File("E:\\TUITION.pdf");
		ResponseBuilder response=Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; file name=DisplayNmae-TUITION.pdf");
		return response.build();
		
	}
//---to upload a file to the server with restful
	
	
/*	
	@POST
	@Path("/5")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	
	public String uploadFile(@FormDataParam("file") InputStream fileInputStream
,@FormDataParam("file") FormDataContentDisposition contentDispositionHeader)
// ,@FormParam("name") String path)
	{
		
String filename =  contentDispositionHeader.getFileName();		
		saveToDisk(fileInputStream,"test.txt");
		
		return "file uploaded";
	}
	*/
	public void saveToDisk(InputStream fileInputStream,String path){
		String uploadedFileLocation="E://upload/"+path;
		try{
			OutputStream out=new FileOutputStream(new File(uploadedFileLocation));
			int read=0;
			byte[] bytes=new byte[1024];
			
			out=new FileOutputStream(new File(uploadedFileLocation));
			while((read=fileInputStream.read(bytes))!=-1){
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
}
