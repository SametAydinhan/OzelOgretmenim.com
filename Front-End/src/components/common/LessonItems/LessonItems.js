import React from 'react'
import { Link } from 'react-router-dom';
import './LessonItems.css'

const LessonItems = () => {
  return (
    <div className='lessons-container'>
      <div className='items'>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
      </div>
      <div className='items'>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
      </div>
      <div className='items'>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
        <div className='item'>
          <Link className='subject'>
            <div className='private-lesson-box'>
              <div className='subject-icon'>
                <img
                  src={require("../../../assests/images/subject/matematik.png")}
                  alt='Math'
                />
              </div>
              <div className='subject-container'>
                <div className='subject-name'>Matematik</div>
                <div className='subject-description'>21.532 Öğretmen</div>
              </div>
            </div>
          </Link>
        </div>
      </div>
    </div>
  );
}

export default LessonItems