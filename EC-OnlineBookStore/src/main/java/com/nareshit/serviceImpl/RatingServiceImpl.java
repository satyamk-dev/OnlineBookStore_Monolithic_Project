package com.nareshit.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.entity.BooksModule;
import com.nareshit.entity.Customer;
import com.nareshit.entity.Ratings;
import com.nareshit.exceptions.BookIdNotFoundException;
import com.nareshit.exceptions.CustmerIDNotFoundException;
import com.nareshit.model.RatingsDto;
import com.nareshit.repository.BooksModuleRepo;
import com.nareshit.repository.CustmerRepoo;
import com.nareshit.repository.RatingsRepo;
import com.nareshit.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired 
	private  CustmerRepoo custmerRepoo;
	@Autowired 
	private BooksModuleRepo booksModuleRepo;
	@Autowired 
	private RatingsRepo ratingsRepo;

	@Override
	public Ratings createRatingRivews(RatingsDto ratingsDto) {
		
		 //  Step 1: Check if customer exists in DB using ID
	    // If not found, throw custom exception "Customer Id Not Found"
	    Customer customer = custmerRepoo.findById(ratingsDto.getCusmerId())
	        .orElseThrow(() -> new CustmerIDNotFoundException("Custmer Id Not found"));
	    
	    
	    //  Step 2: Check if book exists in DB using ID
	    // If not found, throw custom exception "Book Id not Found"
	    BooksModule booksModule = booksModuleRepo.findById(ratingsDto.getBookId())
	        .orElseThrow(() -> new BookIdNotFoundException("Book Id not Found"));
	    
	    Ratings rrr = new Ratings();
	    rrr.setBooksModule(booksModule);
	    rrr.setCustomer(customer);
	    rrr.setRate(ratingsDto.getRate());
	    rrr.setReviewText(ratingsDto.getReviewText());
	    ratingsRepo.save(rrr);
		return rrr;
	}

	@Override
	public List<Ratings> getByAllReview() {
		
		return ratingsRepo.findAll();
	}

}
