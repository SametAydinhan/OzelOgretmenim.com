import React from 'react';
import styled from './TutorCard.module.css';
import { Link } from 'react-router-dom';


const TutorCard = ({tutors}) => {
  return tutors.map((tutor) => (
    <Link to={`/tutor-advertisements/${tutor.id}`} className={styled['tutor-card-link']}>
      <div key={tutor.id} className={styled['tutor-card']}>
        <div className={styled['tutor-img']}>
          <img
            src={require('../assests/images/tutor/tutor1.jpg')}
            alt='tutor'
          />
        </div>
        <div className={styled.description}>
          <h3 className={styled.title}>{tutor.name}</h3>
          <p>
            <i class='fa-solid fa-location-dot'></i>
            {tutor.city}
          </p>
          <p>
            <i class='fa-solid fa-graduation-cap'></i>
            {tutor.subject}
          </p>
          <h4 className={styled.title}>{tutor.title}</h4>
          <p>{tutor.description}</p>
          <div className={styled['price-container']}>
            {tutor.price}₺<span>/saat</span>
          </div>
        </div>
      </div>
    </Link>
  ));
};

export default TutorCard;
