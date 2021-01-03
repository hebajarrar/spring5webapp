package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}



	@Override
	public void run(String... args) throws Exception {
	    System.out.println("Staring in BootStrap");
		Publisher publisher=new Publisher();
		publisher.setName("Ali");
		publisher.setCity("Amman");
		publisher.setState(null);
		publisherRepository.save(publisher);
		System.out.println("Publisher count:"+publisherRepository.count());
      Author anas=new Author("Anas","ABC");
      Book java=new Book("new java book","12345");
      anas.getBooks().add(java);
      java.getAuthor().add(anas);
      java.setPublisher(publisher);
      publisher.getBooks().add(java);
      authorRepository.save(anas);
      bookRepository.save(java);
      publisherRepository.save(publisher);

      Author ahmad=new Author("Ahmad","ABC");   
      Book python=new Book("new python book","67890");
      ahmad.getBooks().add(python);
      python.getAuthor().add(ahmad);
      python.setPublisher(publisher);
      publisher.getBooks().add(python);
      authorRepository.save(ahmad);
      bookRepository.save(python);
      publisherRepository.save(publisher);

      System.out.println("Number of Books: "+bookRepository.count());
      System.out.println("Number of books assigened to Publisher: "+publisher.getBooks().size());
      
      
      
      
	}
	
	

}
