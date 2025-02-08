package com.codingnomads.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    // inject a bean of the QuoteService into the class reference
    @Autowired
    QuoteService quoteService;

    // the path to your endpoint will be mapped to (http://localhost:8080/quote)
    @GetMapping("/quote")
    public String quote(Model model) {
        // get a random quote from the service
        var quote = quoteService.getRandomQuote();

        // attach that quote to the data model
        model.addAttribute("quote", quote);

        // return the view "getting_started/quote.html"
        return "getting_started/quote";
    }
}
