import React from "react";
import Header from "../components/layout/Header";
import "./Home.css";
import Button from "../components/common/Button";
import { Link } from "react-router-dom";
import LessonItems from "../components/common/LessonItems/LessonItems";

const Home = () => {
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
                  Kendiniz veya çocuğunuz için en ideal öğretmeni hemen bul.
                </li>
                <li>Alanında uzman eğitmenlerden en iyi dersleri al.</li>
              </ul>
              <div className='searchbar-container'>
                <input type='text' placeholder='Hangi dersi almak istersin?' />
                <Button
                  styled={{
                    width: "300px",
                    height: "35px",
                    display: "flex",
                    justifyContent: "center",
                    alignItems: "center",
                  }}
                >
                  Öğetmen Bul
                </Button>
              </div>
            </div>
            <div className='image'>
              <img
                src={require("../assests/images/ozelders.png")}
                alt='ozel ders almak icin en iyi platform'
              />
            </div>
          </div>
        </div>
      </section>
      <section className='lessons'>
        <LessonItems />
      </section>
    </>
  );
};

export default Home;
