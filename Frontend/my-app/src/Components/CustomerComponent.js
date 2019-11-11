import React from "react";
import { callGet } from "../service/ApiService";
import { GET_CUSTOMER } from "../common/Urlconstants";


class CustomerComponent extends React.Component{

constructor(props){
super(props);
this.state={
    customerdata:null
}
}

componentDidMount(){
    callGet(GET_CUSTOMER).then(response=>{
        this.setState({customerdata:response.data});

    })
}
    render(){
        return(
<div>
    Hello world {this.state.customerdata && this.state.customerdata[0].firstname}
</div>

        );
    }
}

export default CustomerComponent;