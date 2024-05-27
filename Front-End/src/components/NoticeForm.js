import React, { useState, useContext } from 'react';
import styled from './NoticeForm.module.css';
import { Context } from '../context/Context';
import axios from 'axios';

const NoticeForm = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [price, setPrice] = useState('');
  const { setAppointment, appointment } = useContext(Context);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const notice = {
      title: title,
      description: description,
      price: price,
    };

    // Ilan oluşturma işlemleri
    try {
      const response = await axios.post(
        'http://localhost:8080/notice/create',
        notice
      );
      console.log('Notice response:', response.data);
      setAppointment(!appointment);
      console.log('Appointment:', appointment);
    } catch (error) {
      console.error('Appointment failed:', error.response.data);
    }
  };

  return (
    <div className={styled['main-container']} onSubmit={handleSubmit}>
      <form className={styled['form-container']}>
        <div className={styled['title']}>
          <label htmlFor='title'>Başlık</label>
          <input
            type='text'
            id='title'
            name='title'
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder='Lütfen dersiniz için bir başlık girin.'
            required
          />
        </div>
        <div className={styled.description}>
          <label htmlFor='description'>Açıklama</label>
          <textarea
            id='description'
            name='description'
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            placeholder='İlanınızda gözükecek bilgileri yazın...'
            required
          />
        </div>
        <div className={styled.price}>
          <label htmlFor='price'>Fiyat</label>
          <input
            type='text'
            id='price'
            name='price'
            value={price}
            onChange={(e) => setPrice(e.target.value)}
            placeholder='Lütfen saatlik ücretinizi girin.'
            required
          />
        </div>
        <button type='submit' className={styled['submit-btn']}>
          Gönder
        </button>
      </form>
    </div>
  );
};

export default NoticeForm;
