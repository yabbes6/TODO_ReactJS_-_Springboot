import React, { useEffect, useState } from "react"
import api from "../api/axiosConfig"
import Card from "../UI/Card"
import Planform from './planform';
import AddPlan from "./addPlan";


import classes from "./plans.module.css"

const Plans = (props) => {
    const [plans, setPlans] = useState([]);
    const [isEdit, setIsEdit] = useState(false);
    const [selectedPlan, setSelectedPlan] = useState(null);

    useEffect(() => {
        loadPlans();
    }, []);

    const loadPlans = async () => {
        try {
            const response = await api.get("/all");
            setPlans(response.data);
        } catch (error) {
            console.error("Error loading plans:", error);
        }
    };

    const deletePlan = async (planId) => {
        await api.post(`/delete/${planId}`)
        editCancel()
        loadPlans();
    };

    const editPlan = async (planId, updatedData) => {


            await api.post("/update", {
                id: planId,
                comment: updatedData.plan,
                date: updatedData.date,
                time: updatedData.time
            });
            editCancel()
            loadPlans();

            
        
    };


    const editOpen = async (id) => {
        setIsEdit(true);
        const selected = plans.find((plan) => plan.id === id);
        setSelectedPlan(selected);
    }
    const editCancel = () => {
        setIsEdit(false);
        setSelectedPlan(null);
    }

    return (
        <React.Fragment>
            <AddPlan onSave={loadPlans} ></AddPlan>
            <Card>
                <div className={classes.subCard}>
                    {plans.map((plan) => (
                        <div key={plan.id} className={classes.title}>
                            <div className={classes.title1}>{plan.comment}</div>
                            {!isEdit && <button className={"btn btn-outline-success " + classes.button1} onClick={() => editOpen(plan.id)}>Edit</button>}
                            <button className={"btn btn-outline-danger " + classes.button2} onClick={() => deletePlan(plan.id)}>Delete</button>
                            {isEdit && selectedPlan.id === plan.id &&(
                                <Planform
                                    onCancel={editCancel}
                                    onSave = {(id, updatedplan) => editPlan(id, updatedplan)}
                                    id={selectedPlan.id}
                                    plans={selectedPlan}
                                ></Planform>)}
                        </div>

                    ))}
                </div>

            </Card>
        </React.Fragment>
    );
};

export default Plans;
