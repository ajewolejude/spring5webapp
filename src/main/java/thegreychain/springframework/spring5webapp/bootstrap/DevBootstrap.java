package thegreychain.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import thegreychain.springframework.spring5webapp.model.Author;
import thegreychain.springframework.spring5webapp.model.Book;
import thegreychain.springframework.spring5webapp.model.Publisher;
import thegreychain.springframework.spring5webapp.repositories.AuthorRepository;
import thegreychain.springframework.spring5webapp.repositories.BookRepository;
import thegreychain.springframework.spring5webapp.repositories.PublisherRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    public void initData(){

        //jude

        Publisher publisher1 = new Publisher("Gay Gibson","12A SA, California");
        publisherRepository.save(publisher1);
        Author jude = new Author("Jude","Ajewole");
        Book ddd = new Book("Data Driven Design", "1234", publisher1);
        jude.getBooks().add(ddd);
        ddd.getAuthors().add(jude);

        authorRepository.save(jude);
        bookRepository.save(ddd);



        //mike

        Publisher publisher2 = new Publisher("Ray Fringe","23B LA Los Angeles");
        publisherRepository.save(publisher2);
        Author mike = new Author( "Mike","Adekunle");
        Book java = new Book("Into to Java", "12342",publisher2);
        mike.getBooks().add(java);
        java.getAuthors().add(mike);

        authorRepository.save(mike);
        bookRepository.save(java);

    }


}
