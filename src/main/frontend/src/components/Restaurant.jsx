import { useEffect, useState } from "react";
import axios from "axios"

export const Restaurant = () => {
    const [restaurants, setRestaurants] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:3000/api/restaurants").then((res) => {setRestaurants(res.data);
        })
    }, []);

    return (
        <div>
            {restaurants.map(restaurant => (
                <p>
                    {restaurant.id} {restaurant.name} {restaurant.addressSi} {restaurant.addressGu} {restaurant.addressDong}
                </p>
            ))}
        </div>
    )
}