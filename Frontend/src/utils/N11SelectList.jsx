import React from 'react'
import { Label } from 'reactstrap'
import { useField } from 'formik'

export default function  N11SelectList({ ...props}) {
    const [field, meta] = useField(props)
    return (
        <div>
            <Label htmlFor={props.id}>{props.placeholder}</Label>
            <select {...field} name={props.name} id={props.id}   className="form-control" >
                <option key={props.key} value={""}>Seçiniz</option>
                {Object.keys(props.options).map(opt => (<option key={opt} value={opt}>{props.options[opt]}</option>))}
            </select>
            {meta.touched && !!meta.error ? (
                <span className="text-danger"><b>{meta.error}</b></span>
            ) : null}
        </div>
    )
}