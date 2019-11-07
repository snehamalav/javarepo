package controller;





import java.util.List;

import model.RestResponse;
import model.Track;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import service.MyService;

@Path("/tracks")
public class MyController {
     @GET
     @Produces(MediaType.APPLICATION_JSON)
	 public List<Track> getAllTracks(){
    	 List<Track> tlist= new MyService().getAllTracks();
		return tlist;
	 }
     @GET
     @Path("/{title}")
     @Produces(MediaType.APPLICATION_JSON)
   public Track gettrackDetails(@PathParam("title") String title){
	   Track track=new MyService().gettrackDetails(title);
	return track;
	   
   }
     @POST
     @Path("/post")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public RestResponse registerTrack(Track track)
     {
    	 RestResponse restResponse=new RestResponse();
    	 boolean flag=new MyService().registerTrack(track);
		if(flag)
		{
			restResponse.setCode(200);
			restResponse.setMessage("successfully added");
			
		}
		else
		{
			restResponse.setCode(-1);
			restResponse.setMessage("not successfully added");
		}
    	 return restResponse;
     }
     
     @DELETE
     @Path("/delete/{title}")
     @Produces(MediaType.APPLICATION_JSON)
     public RestResponse deleteTrack(@PathParam("title") String title)
     {
    	 RestResponse restResponse=new RestResponse();
    	boolean flag=new MyService().deleteTrack(title);
		if(flag)
		{
			restResponse.setCode(200);
			restResponse.setMessage("successfully deleted");
			
		}
		else
		{
			restResponse.setCode(-1);
			restResponse.setMessage("not deleted successfully");
		}
    	 return restResponse;
     }
     
     @PUT
     @Path("/update")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public RestResponse updateTrack(Track track)
     {
    	 RestResponse restResponse=new RestResponse();
    	boolean flag=new MyService().updateTrack(track);
		if(flag)
		{
			restResponse.setCode(200);
			restResponse.setMessage("successfully updated");
			
		}
		else
		{
			restResponse.setCode(-1);
			restResponse.setMessage("not updated successfully");
		}
    	 return restResponse;
     }
     
}
