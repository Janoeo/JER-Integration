import json
import os

from icecream import ic

not_metal = {"sulfur", "apatite", "cinnabar", "niter", "oil_sand"}

for file in os.listdir("thermal_ores_json"):
    if not file.endswith(".json"):
        continue
    with open(os.path.join("thermal_ores_json", file), "r") as in_file:
        config = json.loads(in_file.read())
    size = config["feature"]["config"]["size"]
    for placement in config["placement"]:
        if placement["type"] == "minecraft:count":
            count = placement["count"]
        if placement["type"] == "thermal:config":
            ore = placement["config"]
        if placement["type"] == "minecraft:height_range":
            max_inclusive = placement["height"]["max_inclusive"]["absolute"]
            min_inclusive = placement["height"]["min_inclusive"]["absolute"]
            midY = int((min_inclusive + max_inclusive) / 2)
            rangeY = max_inclusive - midY
    raw = ore.replace("_ore", "")
    if raw not in not_metal:
        raw = f"raw_{raw}"
    ic(ore, raw, count, size, min_inclusive, max_inclusive, midY, rangeY)
    print(fr"""JERIntegrationUtils.register(
                registry,
                new ItemStack(BLOCKS.get("{ore}")),
                new ItemStack(BLOCKS.get(deepslate("{ore}"))),
                new ItemStack(ITEMS.get("{raw}")),
                new DistributionTriangular(
                        {count},
                        {size},
                        {midY},
                        {rangeY}
                )
        );""")
