import React from 'react'
import classes from "./planform.module.css"


const Planform = props => {
    const onSave = (event) => {
        event.preventDefault();
        const planValue = event.target.elements.comment ? event.target.elements.comment.value : '';
        const timeValue = event.target.elements.time ? event.target.elements.time.value : '';
        const dateValue = event.target.elements.date ? event.target.elements.date.value : '';
        console.log(props.id,planValue,timeValue,dateValue)
        props.onSave(props.id, {
            plan: planValue,
            time: timeValue,
            date: dateValue
        });

    };

    return (
        <form className={classes.form} onSubmit={onSave}>
            <input
                className={classes.input2}
                type='text'
                name='comment'
                defaultValue={props.plans.plan}
            />
            <input
                type='time'
                name='time'
                defaultValue={props.plans.time}
            />
            <input
                className={classes.input}
                type='date'
                name='date'
                defaultValue={props.plans.date}
            />
            <button className={"btn btn-success " + classes.cancel} onClick={props.onCancel}>
                Cancel
            </button>
            <button className={"btn btn-success " + classes.submit} type='submit'>
                Submit
            </button>
        </form>

    )
}

export default Planform