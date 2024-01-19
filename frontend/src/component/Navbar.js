import React from 'react'
import styles from '../style/Navbar.module.scss'
import btn from '../style/Button.module.scss'
import { useNavigate } from 'react-router-dom'

const Navbar = () => {

    const navigate = useNavigate()

    const goHome=()=>{
        navigate('/')
    }
    const goLogin=()=>{
        navigate('/login')
    }
    const goSignup=()=>{
        navigate('/Signup')
    }
    return (
        <div className={styles.navbar}>
            <button className={btn.btn} style={{width:'90%'}} onClick={goHome}> Home </button>
            <button className={btn.btn} style={{width:'90%'}} onClick={goLogin}> Login </button>
            <button className={btn.btn} style={{width:'90%'}} onClick={goSignup}> Sign up </button>
        </div>
    )
}

export default Navbar