import React from 'react'

const NoticeForm = () => {
  return (
    <form>
        <div>
            <label htmlFor='title'>Başlık</label>
            <input type='text' id='title' name='title' />
        </div>
        <div>
            <label htmlFor='description'>Açıklama</label>
            <textarea id='description' name='description' />
        </div>
        <div>
            <label htmlFor='price'>Fiyat</label>
            <input type='number' id='price' name='price' />
        </div>
        <button type='submit'>Gönder</button>
    </form>
  )
}

export default NoticeForm
