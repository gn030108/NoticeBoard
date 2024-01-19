import React from 'react'
import styles from '../style/Login.module.scss'
import btn from '../style/Button.module.scss'
import Navbar from '../component/Navbar'
import { LoginActions } from '../redux/reducer/LoginReducer';
import { useDispatch, useSelector } from 'react-redux';


const Login = () => {

    const dispatch = useDispatch();
    const id = useSelector((state)=>state.Login.id)
    const pw = useSelector((state)=>state.Login.pw)


    const handleInputChange = (e) => {
        const { name, value } = e.target;

        if (name==='id'){
            dispatch(LoginActions.getId(value))
        }
        else if (name==='pw'){
            dispatch(LoginActions.getPw(value))
        }
    }

    const login=()=>{
        dispatch(LoginActions.reset())
    }

    return (
        <div className={styles.content}>
            <Navbar/>
            <div className={styles.box}>
                <form>
                    <input placeholder='Id' name="id"  value={id} onChange={handleInputChange}></input>
                    <input placeholder='Pw' name="pw" type='password'  value={pw} onChange={handleInputChange}></input>
                </form>
                <div className={styles.button}>
                    <button className={`${btn.custom}, ${btn.login}`} onClick={login}>Login !</button>
                </div>
            </div>
        </div>
    )
}

export default Login
