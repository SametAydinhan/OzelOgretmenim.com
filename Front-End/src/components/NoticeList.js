import React, { useEffect, useContext,useState } from 'react';
import styled from './NoticeList.module.css';
import axios from 'axios';
import { UserContext } from '../context/UserContext';
import { Context } from '../context/Context';
const NoticeList = () => {
    const {getBasicAuthHeader,user} = useContext(Context)
  const { tutorDetail } = useContext(UserContext);
  const [notices, setNotices] = useState([]); //[1]
  useEffect(() => {
    const fetchNotices = async () => {
      try {
        const headers = {
          Authorization: getBasicAuthHeader(user.username, user.password),
          'Content-Type': 'application/json',
        };
        const response = await axios.get(
          `http://localhost:8080/notice/myNotices/${tutorDetail.id}`,
            {
                headers: headers,
            }
        );
        console.log('Notices:', response.data);
        setNotices(response.data);
      } catch (error) {
        console.error('Failed to fetch notices:', error);
      }
    };
    fetchNotices();
  }, []);
  return notices.map((notice) => (
    <div key={notice.id} className={styled['notice-container']}>
      <h3>{notice.title}</h3>
      <p className={styled.price}>
        <span>{notice.price}</span>₺
      </p>
      <p>
        <i className='fa-solid fa-graduation-cap'></i>
        {notice.tutor.subject}
      </p>
      <p>
        <i className='fa-solid fa-location-dot'></i>
        {notice.tutor.city}
      </p>
      <p className={styled['description']}>{notice.description}</p>
      <button onClick={async () => {
 try {
   const headers = {
     Authorization: getBasicAuthHeader(user.username, user.password),
     'Content-Type': 'application/json',
   };
   const response = await axios.delete(
     `http://localhost:8080/notice/delete/${notice.id}`,
     {
       headers: headers,
     }
   );
   console.log('Notice response:', response.data);
 } catch (error) {
   console.error('Notice failed:', error);
 }
      }} className={styled['remove-btn']}>Kaldir</button>
    </div>
  ));
};

export default NoticeList;
