import React, { useState, useEffect } from 'react';
import Header from '../components/layout/Header';
import './Home.css';
import Button from '../components/common/Button';
import { Link } from 'react-router-dom';
import LessonItems from '../components/common/LessonItems/LessonItems';
import axios from 'axios'; // Axios kütüphanesini import edin

const Home = () => {
  // Tutor bilgilerini saklamak için bir state oluşturun
  const [tutors, setTutors] = useState([]);

  // Component yüklendiğinde backend'den tutor verilerini çekin
  useEffect(() => {
    fetchTutors();
  }, []);

  // Tutor verilerini backend'den çeken fonksiyon
  const fetchTutors = async () => {
    try {
      const response = await axios.get('http://localhost:8080/tutor'); // Backend'inizin URL'sini ve API rotasını buraya ekleyin
      setTutors(response.data); // Backend'den gelen veriyi state'e kaydedin
    } catch (error) {
      console.error('Error fetching tutors:', error);
    }
  };

  return (
    <>
      <Header />
      <section className='home-banner'>
        <div className='container'>
          <div className='items-container'>
            <div className='content'>
              <h2>
                <span>En İyi Öğretmenlerden</span> Online Veya Yüz Yüze Dersler
                Alın
              </h2>
              <ul>
                <li>
                  <i className='fa-solid fa-circle-check'></i> Kendiniz veya
                  çocuğunuz için en ideal öğretmeni hemen bul.
                </li>
                <li>
                  <i className='fa-solid fa-circle-check'></i> Alanında uzman
                  eğitmenlerden en iyi dersleri al.
                </li>
              </ul>
              <div className='searchbar-container'>
                <input type='text' placeholder='Hangi dersi almak istersin?' />
                <Button
                  styled={{
                    width: '300px',
                    height: '35px',
                    display: 'flex',
                    justifyContent: 'center',
                    alignItems: 'center',
                  }}
                >
                  Öğetmen Bul
                </Button>
              </div>
            </div>
            <div className='image'>

            </div>
          </div>
        </div>
      </section>
      <section className='lessons'>
        <LessonItems />
      </section>
      <section className='quick-tutor-section'>
        <div className='quick-tutor-container'>
          <h2>Alanında Uzman Öğretmenleri Keşfet!</h2>
          <p>
            Özel ders alanında her yıl onbinlerce öğrenci aradığı öğretmeni
            buluyor
          </p>
          <Button>Hemen Özel Ders Al</Button>
        </div>
      </section>
      {/* Tutor bilgilerini gösterme */}
      <section>
        <div>
          {tutors.map(tutor => (
            <div key={tutor.id}>
              <h3>{tutor.firstName} {tutor.lastName}</h3>
              <p>Şehir: {tutor.city}</p>
              {/* Diğer tutor bilgileri */}
            </div>
          ))}
        </div>
      </section>
    </>
  );
};

export default Home;
