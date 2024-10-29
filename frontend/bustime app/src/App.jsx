import { useState } from 'react'
import {Container, Box} from '@mui/material';
import Home from './pages/Home'


function App() {
  const [count, setCount] = useState(0)

  return (
    <div>
        <Container maxWidth="sm">
            <Box>
                <h1 sx={{color: 'white'}}>Hello world!</h1>
                </Box>
       </Container>

    </div>

  )
}

export default App
