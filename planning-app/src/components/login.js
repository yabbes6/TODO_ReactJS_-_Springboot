import React, { useState } from 'react'
import classes from './login.module.css'

const Login = () => {
    const [email,setEmail] = useState("")
    const [password,setPassword] = useState("")

    const onConnect = () => {
        console.log(email,password)
    }

    return (
        <div className={classes.back}>

            <form className={classes.form} onSubmit={onConnect}>
                <h1 className={classes.title}>Login</h1>
                <input className={classes.input} type='text' placeholder='email' value={email} onChange={e=>setEmail()}/>
                <input className={classes.input} type='password' placeholder='password' value={password} onChange={e=>setPassword()} />
                <button type='submit' className={'btn btn-outline-success '+classes.connecter}>Login</button>
            </form>
        </div>
    )
}

export default Login