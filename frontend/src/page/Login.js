import React from 'react'
import styles from '../style/Login.module.scss'
import btn from '../style/Button.module.scss'
import Navbar from '../component/Navbar'
import { LoginActions } from '../redux/reducer/LoginReducer';
import { useDispatch, useSelector } from 'react-redux';
import  axiosInstance from '../api/axiosInstance';


const Login = () => {

    const dispatch = useDispatch();
    const memberId = useSelector((state)=>state.Login.memberId)
    const password = useSelector((state)=>state.Login.password)


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


    //로그인 Post
    const handleSubmit=(e)=>{
        e.preventDefault();

        axiosInstance.post('/member/login',{
            memberId,
            password,
        })
            .then(response => {
                console.log('로그인 성공')
                alert('로그인 성공 ')
            })
            .catch(error => {
                console.log('로그인 실패')
            })
    }

    return (
        <div className={styles.content}>
            <Navbar/>
            <div className={styles.box}>
                <form>
                    <input placeholder='Id' name="id"  value={memberId} onChange={handleInputChange}></input>
                    <input placeholder='Pw' name="pw" type='password'  value={password} onChange={handleInputChange}></input>
                </form>
                <div className={styles.button}>
                    <button className={`${btn.custom}, ${btn.login}`} onClick={handleSubmit}>Login !</button>
                </div>
            </div>
        </div>
    )
}

export default Login
