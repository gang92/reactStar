import { useEffect, useState } from "react";
import {Restaurant} from "./Restaurant";
import axios from "axios";
import { ShowRestaurantDetail } from "./ShowRestaurantDetail";


export const RestaurantList = (props) => {
    const [restaurants, setRestaurants] = useState([]);
    const [selectedRestaurantId, setSelectedRestaurantId] = useState(null);

    useEffect(() => {
        axios.get("http://localhost:3000/api/restaurants").then((res) => {setRestaurants(res.data);
        })
    }, []);
    
    const handleRestaurantClick = (restaurantId) => {
        console.log("Restaurant clicked with ID:", restaurantId);
        setSelectedRestaurantId(restaurantId);
      };
    
      return (
        <div>
          <div>
            {restaurants.map((restaurant) => (
              <Restaurant
                id={restaurant.id}
                name={restaurant.name}
                addressSi={restaurant.addressSi}
                addressGu={restaurant.addressGu}
                addressDong={restaurant.addressDong}
                onClick={() => handleRestaurantClick(restaurant.id)}
              />
            ))}
          </div>
          <div>
            {selectedRestaurantId && (
              <ShowRestaurantDetail restaurantId={selectedRestaurantId} />
            )}
          </div>
        </div>
      );
    };