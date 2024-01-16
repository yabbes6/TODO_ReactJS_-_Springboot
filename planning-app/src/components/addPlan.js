import React from "react"
import { useState } from "react";
import classes from "./addPlan.module.css"
import api from "../api/axiosConfig"


const AddPlan = (props) => {

    const [plan, setPlan] = useState("");
    const [datePlan, setDate] = useState("");
    const [timePlan, setTime] = useState("");
    const [errorMessage, setErrorMessage] = useState(null);


    const EntryPlan = (event) => {
        setPlan(event.target.value);
    }
    const EntryDatePlan = (event) => {
        setDate(event.target.value);
    }
    const EntryTimePlan = (event) => {
        setTime(event.target.value);
    }

    const save = async (event) => {
        event.preventDefault();

        const isoDateTime = `${timePlan}:00`;

        try {
            const response = await api.post("/add", {
                comment: plan,
                date: datePlan,
                time: isoDateTime
            });

            props.onSave()
            setPlan("");
            if (response.data) {
                console.log(response.data);
                setErrorMessage(response.data.message);
            } else {
                console.error('Invalid response format:', response);
                setErrorMessage('Failed to save plan. Please try again.');
            }

        } catch (response) {
            console.log('Failed to save plan:', response.data);
            if (response.data) {
                setErrorMessage(response.data);
            } else {
                setErrorMessage('Failed to save plan. Please try again.');
            }
        }
    }
    return (
        <React.Fragment>
            <form className={classes.title} onSubmit={save}>
                <input className={classes.input2} type='text' value={plan} onChange={EntryPlan} placeholder='enter your plan for today' />
                <input type='time' value={timePlan} onChange={EntryTimePlan} />
                <input className={classes.input} type='date' value={datePlan} onChange={EntryDatePlan} />
                <button className={"btn btn-success " + classes.submit} type="submit">Submit</button>
            </form>
            {errorMessage && <div className={classes.error}>{errorMessage}</div>}
        </React.Fragment>
    )
}
export default AddPlan;