import { useEffect, useState } from "react";
import {Restaurant} from "./Restaurant";
import axios from "axios"

export const RestaurantList = (props) => {
    const [restaurants, setRestaurants] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:3000/api/restaurants").then((res) => {setRestaurants(res.data);
        })
    }, []);

    return (
        <div>
            {restaurants.map(restaurant => (
                <Restaurant
                id = {restaurant.id}
                name = {restaurant.name}
                addressSi = {restaurant.addressSi}
                addressGu = {restaurant.addressGu}
                addressDong = {restaurant.addressDong}
                />
            ))}
        </div>
    )
}