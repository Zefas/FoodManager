
## API - Voting

GET: http://localhost:9090/food/votes/get/2015-11-25

GET: http://localhost:9090/food/votes/winner/2015-11-25

POST: http://localhost:9090/food/votes/add

    {"userId": -1, "restaurantId": -2}



## API - Restaurants

GET: http://localhost:9090/food/restaurant/get

POST: http://localhost:9090/food/restaurant/add

    {"id": 1, "name": "Restaurant 01", "menuItems": [{"name": "Item 01", "price": 20}, {"name": "Item 02", "price": 15}]}

POST: http://localhost:9090/food/restaurant/update

    {"id": null, "name": "Restaurant 01", "menuItems": [{"name": "Item 01", "price": 20}, {"name": "Item 02", "price": 15}]}

