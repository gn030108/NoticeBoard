import React from 'react'
import { WriteActions } from '../redux/reducer/writeReducer'
import TextareaAutosize from 'react-textarea-autosize';
import styles from '../style/Write.module.scss'
import btn from '../style/Button.module.scss'


const Rewrite = () => {



    return (
        <div className={styles.container}>{/*보라색 배경*/}
            <div className={styles.whiteboard}>{/*흰 배경*/}
                <div className={styles.border}>{/*글 쓰는 곳 테두리*/}
                    <div className={styles.main}>{/*가운데 몰기*/}
                        <textarea rows={1} placeholder='제목'/>{/*제목*/}
                        <TextareaAutosize 
                        className={styles.content}
                        minRows={1}
                        maxRows={20}
                        placeholder='내용' 
                        />{/*내용*/}
                    </div>
                </div>
                <div className={styles.button}>
                        <button className={`${btn.custom}, ${btn.write}`} >수정</button>
                    </div>
            </div>
        </div>
    )
}

export default Rewrite

//   <div></div>
//   {/**/}
//   className={}