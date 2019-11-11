export const callGet=(url,data)=>{
    return fetch(url,{
        method:"GET"
    }).then(response=>{
              return response.json()
    }).then(data=>{
        console.log('response from server'+data)
        if(data.success===false){
                return {
                errorMsg:data.message
                };
        }
        return data;
    }).catch(err=>{
        console.log('error'+err)
        return{
            errorMsg:err.message
            }
    })
}