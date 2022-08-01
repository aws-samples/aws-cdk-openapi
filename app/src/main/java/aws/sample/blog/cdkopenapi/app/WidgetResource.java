package aws.sample.blog.cdkopenapi.app;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class WidgetResource {
	
	private static Logger logger = LoggerFactory.getLogger(WidgetResource.class);

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
	public Response ping() {
        logger.info("Ping invoked..");

		return Response.ok().entity("Pong...").build();
	}
    
    @GET
    @Path("/widgets")
    public List<Widget> getWidgets() {
    	logger.info("getWidgets");
    	
		List<Widget> widgets = new ArrayList<Widget>();
		 
		Widget widget1 = new Widget(1, "Widget 1", "The first Widget");
		Widget widget2 = new Widget(2, "Widget 2", "The second Widget");
		Widget widget3 = new Widget(3, "Widget 3", "The third Widget");
		 
		widgets.add(widget1);
		widgets.add(widget2);
		widgets.add(widget3);
		
		return widgets;
    }
    
    @POST
    @Path("/widgets")
    public Response addWidget(Widget newWidget) {
    	logger.info("New Widget added {}", newWidget);
    	
    	return Response.created(
    			URI.create(String.format("/widgets/%d", newWidget.getId()))
    	).build();
    }
    
    @GET
    @Path("/widgets/{widgetId}")
    public Response getWidgget(@PathParam("widgetId") int widgetId) {
    	logger.info("getWidget {}", widgetId);
    	
		if (widgetId == 1) {
			return Response.ok().entity(new Widget(1, "Widget 1", "The first Widget")).build();
		} else if (widgetId == 2) {
			return Response.ok().entity(new Widget(2, "Widget 2", "The second Widget")).build();
		} else if (widgetId == 3) {
			return Response.ok().entity(new Widget(3, "Widget 3", "The third Widget")).build();
		}

    	return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @PUT
    @Path("/widgets/{widgetId}")
    public Response putWidget(Widget updatedWidget, @PathParam("widgetId") int widgetId) {
    	logger.info("Update Widget Id {} with {}", widgetId, updatedWidget);
    	
    	if (!updatedWidget.getId().equals(widgetId)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
    	
    	return Response.noContent().build();
    }
    
    
}
