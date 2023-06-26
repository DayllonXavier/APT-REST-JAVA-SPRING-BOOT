import { useEffect, useState } from 'react'
import './App.css'
import ListUser from './ListUser'
import FilterSearch from './FilterSearch'
import API from './config/API'

function App() {
  const [users, setUsers] = useState([])
  const [filter, setFilter] = useState("")

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(filter)
    console.log(API + "?filter=" + filter)

    
      /*fetch(API + "?filter=" + filter, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then(response => response.json())
        .then(data => {
          setUsers(data)
        })*/
      
  };

  useEffect(() => {
      fetch(API, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then(response => response.json())
        .then(data => {
          setUsers(data)
        })
    }
  , [])
  
  return (
    <div className='App'>
      <FilterSearch filter={filter} setFilter={setFilter} handleSubmit={handleSubmit} />
      <ListUser users={users} setUsers={setUsers} />
    </div>
  )
}

export default App
