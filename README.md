"# orderManagementSystem" 

h2 console
	http://localhost:8181/h2-console/


get price quote api
	GET localhost:8765/quote-service/quote/productId/{productId}/country/{country}
	
	returns object
		quote 
		{
			Long quoteId;
			String productId;
			String country;
			float ProductPrice;
			String currency;
			float tax;
			float discount;
			float totalQuotePrice;
			String port;		// to demonstrate scalabity.
		}

submit order api

	POST localhost:8765/order-service/order/customerId/123
			reqest body takes quote object returned by "get price quote" api
	
	returns object
		payment 
		{
			Long orderId;
			String paymentLink;
			float totalQuotePrice;
		}
	