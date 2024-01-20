import React from 'react'
import styles from '../style/Signup.module.scss'
import btn from '../style/Button.module.scss'
import Navbar from '../component/Navbar'
import { SignupActions } from '../redux/reducer/SignupReducer';
import { useDispatch, useSelector } from 'react-redux';

const Signup = () => {

    const dispatch = useDispatch();

    const memberId = useSelector((state)=>state.SignUp.memberId)
    const password = useSelector((state)=>state.SignUp.password)
    const name = useSelector((state)=>state.SignUp.name)

    const handleInputChange = (e) => {
        const { name, value } = e.target;

        if (name==='id'){
            dispatch(SignupActions.getId(value))
        }
        else if (name==='pw'){
            dispatch(SignupActions.getPw(value))
        }
        else if (name==='name'){
            dispatch(SignupActions.getName(value))
        }
    }

    const Signup=()=>{
        dispatch(SignupActions.reset())
    }



    return (
        <div className={styles.content}>
            <Navbar/>
            <div className={styles.box}>
                <div className={styles.main}>
                    <input placeholder='Id' name='id' value={memberId} onChange={handleInputChange}></input>
                    <input placeholder='Pw' name='pw' value={password} onChange={handleInputChange}></input>
                    <input placeholder='Name' name='name' value={name} onChange={handleInputChange}></input>
                </div>
                <div>
                    <button className={`${btn.custom}, ${btn.login}`} onClick={Signup}>SignUp!</button>
                </div>{/*버튼들*/}
            </div>
        </div>
    )
}

export default Signup