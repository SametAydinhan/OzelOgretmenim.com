import React from 'react';
import {useParams, } from 'react-router-dom';
import { DUMMY_DATA } from './TutorAdvertisement';

const TutorDetail = () => {
    const { id } = useParams();
    const tutor = DUMMY_DATA.find((tutor) => tutor.id === parseInt(id));
    if (!tutor) {
        return <h2>Öğretmen Bulunumadı!!!</h2>;
    }
  return <div>TutorDetail</div>;
};

export default TutorDetail;
