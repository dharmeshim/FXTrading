* get trade trasactions
  ------

  request - GET
  request body -
  endpoint - /home/trades


* book trade
  ------

  request - POST
  request body -
    {
        "custmerName": "name",
        "currencyPair": "usdinr",
        "amount": "100"
    }

  endpoint - /home/book


* get trade rate for requesting trade
  -------

  request - POST
  request body -
    {
        "custmerName": "name",
        "currencyPair": "usdinr",
        "amount": "100"
    }

  endpoint - /home/rate
