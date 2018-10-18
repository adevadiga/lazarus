// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');



function solution(S) {
    // write your code in JavaScript (Node.js 8.9.4)
    //console.log(S);
    const photoes = S.split(/\r?\n/),
        citiesTophotoMap = new Map(),
        UUIDToTransmorphedMap = new Map();
    for (let i = 0; i < photoes.length; i++) {
        const UUID = i;
            photo = photoes[i],
            entry = photo.split(',');
        if (entry.length < 3) {
            //throw Error("Invalid Input");
            console.log(`Invalid input ad index: ${i}. Continue to process`)
            continue;
        }
        const city = entry[1].trim();
        if (!citiesTophotoMap.has(city)) {
            const photoesByCity = [];
            citiesTophotoMap.set(city, photoesByCity);
        }
        
        const photoesByCity = citiesTophotoMap.get(city);
        const obj = {
            'name': entry[0].trim(),
            'date': entry[2].trim(),
            'extension': entry[0].trim().split('.')[1],
            'UUID': UUID
        }
        photoesByCity.push(obj);
        UUIDToTransmorphedMap.set(UUID, obj);
    }
    
     
    transformPhotoNames(citiesTophotoMap);
    
    let output = "";
    for (let i = 0; i < photoes.length; i++) {
        const UUID = i;
        output += UUIDToTransmorphedMap.get(UUID).newName + "\n";
    }
     
     return output;
}

function transformPhotoNames(citiesTophotoMap) {
    //Sort map entry by date
    for (var [key, value] of citiesTophotoMap) {
        value.sort(compare);
    }

    for (var [key, value] of citiesTophotoMap) {
        const numberOfEntries = value.length,
            suffixLength = numberOfEntries.toString().length;
        let count = 1;
        for(let i=0; i< value.length; i++) {
            let newName = key,
                suffix = count.toString();
            suffix = suffix.padStart(suffixLength, '0');
            newName = newName + suffix + "." + value[i].extension;
            value[i].newName = newName;
            count++;
        }
   }
}

function compare(obj1, obj2) {
    return new Date(obj1.date).getTime() - new Date(obj2.date).getTime();
}


function appendToSortedArray(array, data) {
    for (let i = 0; i < array.length; i++) {
        //Date t = new Date(array[i].date);
    }
}