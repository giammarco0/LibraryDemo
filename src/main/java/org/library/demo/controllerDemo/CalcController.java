package org.library.demo.controllerDemo;

import org.library.demo.modelsDemo.PriceModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

    @RequestMapping(method = RequestMethod.GET, value = "/calc")
    public ModelAndView calc(
            @RequestParam(value = "price" , required = true) double price,    //required è già true di default
            @RequestParam(value = "discount" , required = true) double discount){
        double finalPrice = price - (price * discount);
        ModelAndView response = new ModelAndView();   /** nuova view alla quale reindirizzare */
        response.setViewName("calc");
        response.addObject("calcResult", finalPrice);

        System.out.println("***********Ritorno stringa 'calc' || CalcController.calc--12");
        return response;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/calcResponse/{pippo}")
    @ResponseBody  /**
                     * il contrario di @Controller --> serve per non fare il redirect ad un'altra view (la risposta rimane nel body)
                     * Non fa entrare nel viewResolver
                     * Se dobbiamo scrivere sia @Controller che @ResponseBody possiamo scrivere @RestController
                     */
    public PriceModel calcOnlyResponse(
            @PathVariable(value = "pippo") String pippo,
            @RequestParam(value = "price") Double price,
            @RequestParam(value = "discount", required = false) Double discount) {

        PriceModel response = new PriceModel();
        response.setPrice(price);
        response.setDiscount(discount == null ? 0 : discount);

        if(discount != null && discount != 0){
            response.setFinalPrice(price - (price * discount));
        }

        return response;
    }
}
