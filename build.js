const ROOT = build({
	module: "com.s8.core.web.carbon",
	dependencies: [
		"S8-api",
		"S8-core-io-xml",
		"S8-core-io-JSON",
		"S8-core-io-bytes",
		"S8-core-arch-silicon",
		"S8-core-arch-titanium",
		"S8-core-bohr-atom",
		"S8-core-bohr-beryllium",
		"S8-core-bohr-lithium",
		"S8-core-bohr-neodymium",
		"S8-core-bohr-neon",
		"S8-core-web-helium"
	],
	target: "S8-core-web-carbon"
});