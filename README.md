
## API - Voting

All votes for day: 
http://localhost:9090/food/votes/get/2015-11-25 (GET)

Add Vote:
http://localhost:9090/food/votes/add (POST)

    {"userId": 1, "restaurantId": 2}

Find Winners of the day (multiple if same no of votes):
http://localhost:9090/food/votes/winner/2015-11-25 (GET)


## API - Restaurants

All restaurants:
http://localhost:9090/food/restaurant/get (GET)

Add new restaurant:
http://localhost:9090/food/restaurant/add (POST)

    {"id": 1, "name": "Restaurant 01", "menuItems": [{"name": "Item 01", "price": 20}, {"name": "Item 02", "price": 15}]}

Update restaurant:
http://localhost:9090/food/restaurant/update (POST)

    {"id": null, "name": "Restaurant 01", "menuItems": [{"name": "Item 01", "price": 20}, {"name": "Item 02", "price": 15}]}

