import { useEffect, useState } from "react";
import {Restaurant} from "./Restaurant";
import axios from "axios";
import { ShowRestaurantDetail } from "./ShowRestaurantDetail";

import Footer from '../page/Footer'

const RestaurantList = (props,{children}) => {
    const [restaurants, setRestaurants] = useState([]);
    const [selectedRestaurantId, setSelectedRestaurantId] = useState(null);

    useEffect(() => {
        axios.get("http://localhost:8080/api/restaurants").then((res) => {setRestaurants(res.data);
        console.log(res.data);
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
          <Footer />
        </div>
      );
    };

export default RestaurantList;