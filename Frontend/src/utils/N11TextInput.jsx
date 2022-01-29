import { useField } from 'formik'
import React from 'react'
import { Input, Label } from 'reactstrap'

export default function N11TextInput({ ...props }) {
    const [field, meta] = useField(props)
    return (
        <div>
            <Label htmlFor={props.id}>{props.placeholder}</Label>
            <Input {...field} {...props}  className="form-control"  placeholder={props.placeholder + ' Giriniz'}  />
            {meta.touched || !!meta.error ? (
                <span className="text-danger"><b>{meta.error}</b></span>
            ) : null}
        </div>
    )
}