package kz.mve.movies.client;

import kz.mve.movieswebservice.wsdl.GetAllMoviesRequest;
import kz.mve.movieswebservice.wsdl.GetAllMoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class MovieClient {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    private WebServiceTemplate webServiceTemplate;

    public GetAllMoviesResponse getMoviesInfo(GetAllMoviesRequest getAllMoviesRequest){
        webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return (GetAllMoviesResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws",getAllMoviesRequest);
    }

}


