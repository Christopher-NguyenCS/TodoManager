import { useState,useEffect } from 'react'
import './App.css'

function App() {
  const [datas, setDatas] = useState();

  useEffect(()=>{
    const fetchReponse = async()=>{
      try {
        const response = await fetch("http://localhost:8080/users");
        const users = await response.json();
        setDatas(users);
        
      } catch (error) {
        return <div>{error}</div>
      }
    }
    fetchReponse();
  },[]);

  if(!datas){
    return <div>no data</div>
  }
  return (
    <>
      <div>
        {datas.map(data =>(
          <li key={data.id}>{data.firstName}</li>
        ))}
      </div>
    </>
  )
}

export default App
