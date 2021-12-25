package _03_intro_to_authenticated_APIs;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;
import _03_intro_to_authenticated_APIs.data_transfer_objects.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import org.springframework.web.util.UriBuilder;

import _01_intro_to_APIs.data_transfer_objects.Result;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class NewsApiTest {

	
    NewsApi newsApi;

    @Mock
    WebClient webClientMock;
    
    @Mock
    ApiExampleWrapper apiExampleWrapper;
    
    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;
    
    @Mock 
    Mono<ApiExampleWrapper> apiWrapperMonoMock;
    
    
    @BeforeEach
    void setUp() {
          MockitoAnnotations.openMocks(this);
          newsApi=new NewsApi();
          newsApi.setWebClient(webClientMock);
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
        String topic="planes";
        Article expectedArticle=new Article();
        expectedArticle.setTitle("What's New on Paramount Plus in January 2022");
        expectedArticle.setContent("I dont know why I thought monthly roundups of whats new on Paramount+ were a good idea, or even necessary. I mean, I guess I do: Sure, the first few months of offerings from the former CBS All Access…");
        expectedArticle.setUrl("https://lifehacker.com/whats-new-on-paramount-plus-in-january-2022-1848247730");
        List<Article> expectedArticles=Collections.singletonList(expectedArticle);
        ApiExampleWrapper expectedExampleWrapper=new ApiExampleWrapper();
        expectedExampleWrapper.setArticles(expectedArticles);
        
    when(webClientMock.get())
        .thenReturn(requestHeadersUriSpecMock);
when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
        .thenReturn(requestHeadersSpecMock);
when(requestHeadersSpecMock.retrieve())
        .thenReturn(responseSpecMock);
when(responseSpecMock.bodyToMono(ApiExampleWrapper.class))
        .thenReturn(apiWrapperMonoMock);
when(apiWrapperMonoMock.block())
        .thenReturn(expectedExampleWrapper);
      
        
        //when
       ApiExampleWrapper story=newsApi.getNewsStoryByTopic(topic);
       System.out.println(story);
       
        //then
       verify(webClientMock, times(1)).get();
       assertEquals(expectedArticle, story.getArticles().get(0));
    }

    @Test
    void itShouldFindStory(){
        //given
String topic="planes";
String storyTitle="What's New on Paramount Plus in January 2022";
String storyLink="https://lifehacker.com/whats-new-on-paramount-plus-in-january-2022-1848247730";
        //when

        //then
    }


}