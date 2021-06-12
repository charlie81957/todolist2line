import React from 'react';
import { useState, useCallback} from 'react';

const DatetimePicker = () => {

    const [limit, setLimit] = useState("")
    const inputLimit = useCallback((e) => { 
        console.log(e.target.value)
        setLimit(e.target.value);
    },[]);

    return (
        <div className="col-12">
            <label htmlFor="firstName" className="form-label">期限</label>
            <div className="input-group date mb-3" id="datetimepicker1" data-target-input="nearest">
                <input type="date" className="form-control datetimepicker-input" data-target="#datetimepicker1" required onChange={inputLimit} />                
            </div>
        </div>
    )
}
export default DatetimePicker;