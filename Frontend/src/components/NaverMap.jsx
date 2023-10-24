import React, { useEffect, useRef } from 'react';

export default function NaverMap() {

  const mapElement = useRef(null);
  const { naver } = window;

  const testMarkers = [];

  useEffect(() => {
    if (!mapElement.current || !naver) return;

    // 지도에 표시할 위치의 위도와 경도 좌표를 파라미터로 넣어줍니다.
    const location = new naver.maps.LatLng(37.5656, 126.9769);
    const mapOptions = {
      center: location,
      zoom: 17,
      zoomControl: true,
    };

    const map = new naver.maps.Map(mapElement.current, mapOptions);
    map.setCursor('pointer');
    const infoWindow = new naver.maps.InfoWindow({ anchorSkew: true });

    const marker = new naver.maps.Marker({
      position: location,
      map,
    });
    
    infoWindow.setContent([
      'tests'
    ].join('\n'));
    infoWindow.open(map, marker);

    naver.maps.Event.addListener(marker, "click" , () => {
      
    });

    //줌을 땡기면 마커업데이트
    naver.maps.Event.addListener(map, 'zoom_changed', () => {
		});
		
		//드래그를 하면 마커업데이트
		naver.maps.Event.addListener(map, 'dragend', () => {
    });
  }, []);

  return (
    <>
      <h1>Dong's Map - Default</h1>
      <div ref={mapElement} style={{ minHeight: '400px' }} />
    </>
  );
}