import React from 'react';
import Header from '../components/layout/Header';
import './Home.css';
import Button from '../components/common/Button';
import LessonItems from '../components/common/LessonItems/LessonItems';
import Footer from '../components/layout/Footer/Footer';
<<<<<<< HEAD
import axios from 'axios';


const Home = () => {
    const [tutors, setTutors] = useState([]);

    useEffect(() => {
        fetchTutors();
    }, []);

    const fetchTutors = async () => {
        try {
            const response = await axios.get('http://localhost:8080/tutor'); // Correct URL
            console.log(response.data); // Gelen veriyi konsola yazdırın
            setTutors(response.data); // Gelen veriyi state'e kaydedin
        } catch (error) {
            console.error('Error fetching tutors:', error);
        }
    };
=======

import { Link } from 'react-router-dom';


const Home = () => {
    //   const [tutors, setTutors] = useState([]);

    //   useEffect(() => {
    //     fetchTutors();
    //   }, []);

    //   const fetchTutors = async () => {
    //     try {
    //         const response = await axios.get('http://localhost:8080'); // Correct URL
    //         console.log(response.data); // Gelen veriyi konsola yazdırın
    //       setTutors(response.data); // Gelen veriyi state'e kaydedin
    //     } catch (error) {
    //       console.error('Error fetching tutors:', error);
    //     }
    //   };
>>>>>>> 7fc480d841bf4d97f7b829d1a2625c5c04229780

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
<<<<<<< HEAD
                                    Öğetmen Bul
=======
                                    Öğretmen Bul
>>>>>>> 7fc480d841bf4d97f7b829d1a2625c5c04229780
                                </Button>
                            </div>
                        </div>
                        <div className='image'>
<<<<<<< HEAD
                            <img src={require('../assests/images/ozelders.png')} alt="" />
=======
                            <img src={require('../assests/images/ozelders.png')} alt='' />
>>>>>>> 7fc480d841bf4d97f7b829d1a2625c5c04229780
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
<<<<<<< HEAD
                    <Button>Hemen Özel Ders Al</Button>
                </div>
            </section>
            < Footer />
=======
                    <Link to={'/tutor-advertisements'}>
                        <Button>Hemen Özel Ders Al</Button>
                    </Link>
                </div>
            </section>
            <Footer />
>>>>>>> 7fc480d841bf4d97f7b829d1a2625c5c04229780
        </>
    );
};

export default Home;
