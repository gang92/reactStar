import React, { useState, useEffect } from "react";
import { useParams } from 'react-router-dom';
import axios from "axios";

const Table = {
  border: "1px solid black"
}

export const ShowRestaurantDetail = ({ restaurantId }) => {
  const id = useParams();

  const [restaurantDetail, setRestaurantDetail] = useState(null);

  useEffect(() => {
    // 이펙트를 이용하여 레스토랑 상세 정보를 가져옵니다.
    if (restaurantId) {
      axios.get(`http://localhost:8080/api/restaurants/${restaurantId}`)
        .then((res) => {
          setRestaurantDetail(res.data);
        })
        .catch((error) => {
          console.error("Error fetching restaurant detail:", error);
        });
    }
    else if (id) {
      axios.get(`http://localhost:8080/api/restaurants/${id.id}`)
        .then((res) => {
          setRestaurantDetail(res.data);
        })
        .catch((error) => {
          console.error("Error fetching restaurant detail:", error);
        });
    }
  }, [restaurantId]);

  if (!restaurantDetail) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>Restaurant Detail</h2>
      <p>ID: {restaurantDetail.id}</p>
      <p>Name: {restaurantDetail.name}</p>
      <p>Address: {`${restaurantDetail.addressSi} ${restaurantDetail.addressGu} ${restaurantDetail.addressDong}`}</p>
      {/* Add more details as needed */}
    </div>
  );
};