import React from 'react'
import { useNavigate } from 'react-router-dom'
import styles from '../style/Home.module.scss'
import btn from '../style/Button.module.scss'
import { homeActions } from '../redux/reducer/homeReducer';
import { useDispatch, useSelector } from 'react-redux';
import Navbar from '../component/Navbar'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faMagnifyingGlass } from "@fortawesome/free-solid-svg-icons";



const Home = () => {

    const dispatch = useDispatch();
    const navigate = useNavigate();

    const name = useSelector((state)=>state.home.name)

    const change = ()=>{
        dispatch(homeActions.getname('성공'))
    }

    const gowrite=()=>{
        navigate('/write')
    }

    return (
    <div className={styles.container}>
        <div className={styles.home}>
            <div className={styles.flexbox}>
                <Navbar/>
                <div className={styles.content}>
                    <div className={styles.header}>
                        <div>게시판</div>


                    </div>{/*헤더*/}

                    <div className={styles.main}>
                        <div>
                            <div>
                                <div className={styles.no}>No</div>{/*숫자*/}
                                <div className={styles.title}>Title</div>{/*제목*/}
                                <div className={styles.writer}>Writer</div>{/*작성자*/}
                            </div>                
                        </div>
                    </div>{/*게시물부분*/}

                    <div className={styles.write} >
                        <button className={`${btn.custom}, ${btn.login}`} onClick={gowrite}>글쓰기</button>
                    </div>

                    <div className={styles.paging}>
                        <div>
                            <input placeholder='검색창'></input>
                            <button>
                                <FontAwesomeIcon icon={faMagnifyingGlass} size="lg" style={{color: "#B197FC",}} />
                            </button>
                        </div>
                    </div>{/*페이징*/}
                </div>
            </div>
        </div>
    </div>    
    )
}

export default Home