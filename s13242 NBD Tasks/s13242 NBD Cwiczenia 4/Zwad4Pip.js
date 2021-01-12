db.people.aggregate([{ $project: { nationality: "$nationality", bmi: { $multiply: [{ $divide: ["$weight", { $multiply: ["$height", "$height"] }] }, 10000] } } }, { $group: { _id: "$nationality", count: { $sum: 1 }, min: { $min: "$bmi" }, avg: { $avg: "$bmi" }, max: { $max: "$bmi" } } }])

