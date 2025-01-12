require recipes-kernel/linux/linux-raspberrypi_6.6.bb

SECTION = "RT kernel"
SUMMARY = "Linux Real time kernel for Raspberrypi"
DESCRIPTION = "Recipe to build real time Linux kernel"

SRC_URI:append = "https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patches-6.6.22-rt27.tar.gz;md5sum=0e236ca865c09588eb398d43254464c5 \
		file://preempt-rt.cfg \
		"
S = "${WORKDIR}/git"

LINUX_VERSION_EXTENSION:append = "-preempt-rt"

do_apply() {
    cd ${WORKDIR}/git
        patch -p1 < ${WORKDIR}/patches/0001-sched-Constrain-locks-in-sched_submit_work.patch
        patch -p1 < ${WORKDIR}/patches/0002-locking-rtmutex-Avoid-unconditional-slowpath-for-DEB.patch
        patch -p1 < ${WORKDIR}/patches/0003-sched-Extract-__schedule_loop.patch
        patch -p1 < ${WORKDIR}/patches/0004-sched-Provide-rt_mutex-specific-scheduler-helpers.patch
        patch -p1 < ${WORKDIR}/patches/0005-locking-rtmutex-Use-rt_mutex-specific-scheduler-help.patch
        patch -p1 < ${WORKDIR}/patches/0006-locking-rtmutex-Add-a-lockdep-assert-to-catch-potent.patch
        patch -p1 < ${WORKDIR}/patches/0007-futex-pi-Fix-recursive-rt_mutex-waiter-state.patch
        patch -p1 < ${WORKDIR}/patches/0008-signal-Add-proper-comment-about-the-preempt-disable-.patch
        patch -p1 < ${WORKDIR}/patches/0009-signal-Don-t-disable-preemption-in-ptrace_stop-on-PR.patch
        patch -p1 < ${WORKDIR}/patches/0010-drm-amd-display-Remove-migrate_en-dis-from-dc_fpu_be.patch
        patch -p1 < ${WORKDIR}/patches/0011-drm-amd-display-Simplify-the-per-CPU-usage.patch
        patch -p1 < ${WORKDIR}/patches/0012-drm-amd-display-Add-a-warning-if-the-FPU-is-used-out.patch
        patch -p1 < ${WORKDIR}/patches/0013-drm-amd-display-Move-the-memory-allocation-out-of-dc.patch
        patch -p1 < ${WORKDIR}/patches/0014-drm-amd-display-Move-the-memory-allocation-out-of-dc.patch
        patch -p1 < ${WORKDIR}/patches/0015-net-Avoid-the-IPI-to-free-the.patch
        patch -p1 < ${WORKDIR}/patches/0016-x86-Allow-to-enable-RT.patch
        patch -p1 < ${WORKDIR}/patches/0017-x86-Enable-RT-also-on-32bit.patch
        patch -p1 < ${WORKDIR}/patches/0018-sched-rt-Don-t-try-push-tasks-if-there-are-none.patch
        patch -p1 < ${WORKDIR}/patches/0019-softirq-Use-a-dedicated-thread-for-timer-wakeups.patch
        patch -p1 < ${WORKDIR}/patches/0020-rcutorture-Also-force-sched-priority-to-timersd-on-b.patch
        patch -p1 < ${WORKDIR}/patches/0021-tick-Fix-timer-storm-since-introduction-of-timersd.patch
        patch -p1 < ${WORKDIR}/patches/0022-softirq-Wake-ktimers-thread-also-in-softirq.patch
        patch -p1 < ${WORKDIR}/patches/0023-zram-Replace-bit-spinlocks-with-spinlock_t-for-PREEM.patch
        patch -p1 < ${WORKDIR}/patches/0024-preempt-Put-preempt_enable-within-an-instrumentation.patch
        patch -p1 < ${WORKDIR}/patches/0025-sched-core-Provide-a-method-to-check-if-a-task-is-PI.patch
        patch -p1 < ${WORKDIR}/patches/0026-softirq-Add-function-to-preempt-serving-softirqs.patch
        patch -p1 < ${WORKDIR}/patches/0027-time-Allow-to-preempt-after-a-callback.patch
        patch -p1 < ${WORKDIR}/patches/0028-serial-core-Use-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0029-serial-21285-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0030-serial-8250_aspeed_vuart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0031-serial-8250_bcm7271-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0032-serial-8250-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0033-serial-8250_dma-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0034-serial-8250_dw-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0035-serial-8250_exar-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0036-serial-8250_fsl-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0037-serial-8250_mtk-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0038-serial-8250_omap-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0039-serial-8250_pci1xxxx-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0040-serial-altera_jtaguart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0041-serial-altera_uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0042-serial-amba-pl010-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0043-serial-amba-pl011-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0044-serial-apb-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0045-serial-ar933x-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0046-serial-arc_uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0047-serial-atmel-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0048-serial-bcm63xx-uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0049-serial-cpm_uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0050-serial-digicolor-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0051-serial-dz-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0052-serial-linflexuart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0053-serial-fsl_lpuart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0054-serial-icom-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0055-serial-imx-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0056-serial-ip22zilog-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0057-serial-jsm-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0058-serial-liteuart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0059-serial-lpc32xx_hs-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0060-serial-ma35d1-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0061-serial-mcf-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0062-serial-men_z135_uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0063-serial-meson-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0064-serial-milbeaut_usio-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0065-serial-mpc52xx-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0066-serial-mps2-uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0067-serial-msm-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0068-serial-mvebu-uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0069-serial-omap-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0070-serial-owl-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0071-serial-pch-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0072-serial-pic32-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0073-serial-pmac_zilog-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0074-serial-pxa-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0075-serial-qcom-geni-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0076-serial-rda-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0077-serial-rp2-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0078-serial-sa1100-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0079-serial-samsung_tty-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0080-serial-sb1250-duart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0081-serial-sc16is7xx-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0082-serial-tegra-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0083-serial-core-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0084-serial-mctrl_gpio-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0085-serial-txx9-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0086-serial-sh-sci-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0087-serial-sifive-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0088-serial-sprd-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0089-serial-st-asc-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0090-serial-stm32-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0091-serial-sunhv-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0092-serial-sunplus-uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0093-serial-sunsab-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0094-serial-sunsu-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0095-serial-sunzilog-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0096-serial-timbuart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0097-serial-uartlite-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0098-serial-ucc_uart-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0099-serial-vt8500-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0100-serial-xilinx_uartps-Use-port-lock-wrappers.patch
        patch -p1 < ${WORKDIR}/patches/0101-printk-Add-non-BKL-nbcon-console-basic-infrastructur.patch
        patch -p1 < ${WORKDIR}/patches/0102-printk-nbcon-Add-acquire-release-logic.patch
        patch -p1 < ${WORKDIR}/patches/0103-printk-Make-static-printk-buffers-available-to-nbcon.patch
        patch -p1 < ${WORKDIR}/patches/0104-printk-nbcon-Add-buffer-management.patch
        patch -p1 < ${WORKDIR}/patches/0105-printk-nbcon-Add-ownership-state-functions.patch
        patch -p1 < ${WORKDIR}/patches/0106-printk-nbcon-Add-sequence-handling.patch
        patch -p1 < ${WORKDIR}/patches/0107-printk-nbcon-Add-emit-function-and-callback-function.patch
        patch -p1 < ${WORKDIR}/patches/0108-printk-nbcon-Allow-drivers-to-mark-unsafe-regions-an.patch
        patch -p1 < ${WORKDIR}/patches/0109-printk-fix-illegal-pbufs-access-for-CONFIG_PRINTK.patch
        patch -p1 < ${WORKDIR}/patches/0110-printk-Reduce-pr_flush-pooling-time.patch
        patch -p1 < ${WORKDIR}/patches/0111-printk-nbcon-Relocate-32bit-seq-macros.patch
        patch -p1 < ${WORKDIR}/patches/0112-printk-Adjust-mapping-for-32bit-seq-macros.patch
        patch -p1 < ${WORKDIR}/patches/0113-printk-Use-prb_first_seq-as-base-for-32bit-seq-macro.patch
        patch -p1 < ${WORKDIR}/patches/0114-printk-ringbuffer-Do-not-skip-non-finalized-records-.patch
        patch -p1 < ${WORKDIR}/patches/0115-printk-ringbuffer-Clarify-special-lpos-values.patch
        patch -p1 < ${WORKDIR}/patches/0116-printk-For-suppress_panic_printk-check-for-other-CPU.patch
        patch -p1 < ${WORKDIR}/patches/0117-printk-Add-this_cpu_in_panic.patch
        patch -p1 < ${WORKDIR}/patches/0118-printk-ringbuffer-Cleanup-reader-terminology.patch
        patch -p1 < ${WORKDIR}/patches/0119-printk-Wait-for-all-reserved-records-with-pr_flush.patch
        patch -p1 < ${WORKDIR}/patches/0120-printk-ringbuffer-Skip-non-finalized-records-in-pani.patch
        patch -p1 < ${WORKDIR}/patches/0121-printk-ringbuffer-Consider-committed-as-finalized-in.patch
        patch -p1 < ${WORKDIR}/patches/0122-printk-Disable-passing-console-lock-owner-completely.patch
        patch -p1 < ${WORKDIR}/patches/0123-printk-Avoid-non-panic-CPUs-writing-to-ringbuffer.patch
        patch -p1 < ${WORKDIR}/patches/0124-panic-Flush-kernel-log-buffer-at-the-end.patch
        patch -p1 < ${WORKDIR}/patches/0125-printk-Consider-nbcon-boot-consoles-on-seq-init.patch
        patch -p1 < ${WORKDIR}/patches/0126-printk-Add-sparse-notation-to-console_srcu-locking.patch
        patch -p1 < ${WORKDIR}/patches/0127-printk-nbcon-Ensure-ownership-release-on-failed-emit.patch
        patch -p1 < ${WORKDIR}/patches/0128-printk-Check-printk_deferred_enter-_exit-usage.patch
        patch -p1 < ${WORKDIR}/patches/0129-printk-nbcon-Implement-processing-in-port-lock-wrapp.patch
        patch -p1 < ${WORKDIR}/patches/0130-printk-nbcon-Add-driver_enter-driver_exit-console-ca.patch
        patch -p1 < ${WORKDIR}/patches/0131-printk-Make-console_is_usable-available-to-nbcon.patch
        patch -p1 < ${WORKDIR}/patches/0132-printk-Let-console_is_usable-handle-nbcon.patch
        patch -p1 < ${WORKDIR}/patches/0133-printk-Add-flags-argument-for-console_is_usable.patch
        patch -p1 < ${WORKDIR}/patches/0134-printk-nbcon-Provide-function-to-flush-using-write_a.patch
        patch -p1 < ${WORKDIR}/patches/0135-printk-Track-registered-boot-consoles.patch
        patch -p1 < ${WORKDIR}/patches/0136-printk-nbcon-Use-nbcon-consoles-in-console_flush_all.patch
        patch -p1 < ${WORKDIR}/patches/0137-printk-nbcon-Assign-priority-based-on-CPU-state.patch
        patch -p1 < ${WORKDIR}/patches/0138-printk-nbcon-Add-unsafe-flushing-on-panic.patch
        patch -p1 < ${WORKDIR}/patches/0139-printk-Avoid-console_lock-dance-if-no-legacy-or-boot.patch
        patch -p1 < ${WORKDIR}/patches/0140-printk-Track-nbcon-consoles.patch
        patch -p1 < ${WORKDIR}/patches/0141-printk-Coordinate-direct-printing-in-panic.patch
        patch -p1 < ${WORKDIR}/patches/0142-printk-nbcon-Implement-emergency-sections.patch
        patch -p1 < ${WORKDIR}/patches/0143-panic-Mark-emergency-section-in-warn.patch
        patch -p1 < ${WORKDIR}/patches/0144-panic-Mark-emergency-section-in-oops.patch
        patch -p1 < ${WORKDIR}/patches/0145-rcu-Mark-emergency-section-in-rcu-stalls.patch
        patch -p1 < ${WORKDIR}/patches/0146-lockdep-Mark-emergency-section-in-lockdep-splats.patch
        patch -p1 < ${WORKDIR}/patches/0147-printk-nbcon-Introduce-printing-kthreads.patch
        patch -p1 < ${WORKDIR}/patches/0148-printk-Atomic-print-in-printk-context-on-shutdown.patch
        patch -p1 < ${WORKDIR}/patches/0149-printk-nbcon-Add-context-to-console_is_usable.patch
        patch -p1 < ${WORKDIR}/patches/0150-printk-nbcon-Add-printer-thread-wakeups.patch
        patch -p1 < ${WORKDIR}/patches/0151-printk-nbcon-Stop-threads-on-shutdown-reboot.patch
        patch -p1 < ${WORKDIR}/patches/0152-printk-nbcon-Start-printing-threads.patch
        patch -p1 < ${WORKDIR}/patches/0153-proc-Add-nbcon-support-for-proc-consoles.patch
        patch -p1 < ${WORKDIR}/patches/0154-tty-sysfs-Add-nbcon-support-for-active.patch
        patch -p1 < ${WORKDIR}/patches/0155-printk-nbcon-Provide-function-to-reacquire-ownership.patch
        patch -p1 < ${WORKDIR}/patches/0156-serial-core-Provide-low-level-functions-to-port-lock.patch
        patch -p1 < ${WORKDIR}/patches/0157-serial-8250-Switch-to-nbcon-console.patch
        patch -p1 < ${WORKDIR}/patches/0158-printk-Add-kthread-for-all-legacy-consoles.patch
        patch -p1 < ${WORKDIR}/patches/0159-serial-8250-revert-drop-lockdep-annotation-from-seri.patch
        patch -p1 < ${WORKDIR}/patches/0160-printk-Avoid-false-positive-lockdep-report-for-legac.patch
        patch -p1 < ${WORKDIR}/patches/0161-drm-i915-Use-preempt_disable-enable_rt-where-recomme.patch
        patch -p1 < ${WORKDIR}/patches/0162-drm-i915-Don-t-disable-interrupts-on-PREEMPT_RT-duri.patch
        patch -p1 < ${WORKDIR}/patches/0163-drm-i915-Don-t-check-for-atomic-context-on-PREEMPT_R.patch
        patch -p1 < ${WORKDIR}/patches/0164-drm-i915-Disable-tracing-points-on-PREEMPT_RT.patch
        patch -p1 < ${WORKDIR}/patches/0165-drm-i915-skip-DRM_I915_LOW_LEVEL_TRACEPOINTS-with-NO.patch
        patch -p1 < ${WORKDIR}/patches/0166-drm-i915-gt-Queue-and-wait-for-the-irq_work-item.patch
        patch -p1 < ${WORKDIR}/patches/0167-drm-i915-gt-Use-spin_lock_irq-instead-of-local_irq_d.patch
        patch -p1 < ${WORKDIR}/patches/0168-drm-i915-Drop-the-irqs_disabled-check.patch
        patch -p1 < ${WORKDIR}/patches/0169-drm-i915-Do-not-disable-preemption-for-resets.patch
        patch -p1 < ${WORKDIR}/patches/0170-drm-i915-guc-Consider-also-RCU-depth-in-busy-loop.patch
        patch -p1 < ${WORKDIR}/patches/0171-Revert-drm-i915-Depend-on-PREEMPT_RT.patch
        patch -p1 < ${WORKDIR}/patches/0172-sched-define-TIF_ALLOW_RESCHED.patch
        patch -p1 < ${WORKDIR}/patches/0173-arm-Disable-jump-label-on-PREEMPT_RT.patch
        patch -p1 < ${WORKDIR}/patches/0174-ARM-enable-irq-in-translation-section-permission-fau.patch
        patch -p1 < ${WORKDIR}/patches/0175-tty-serial-omap-Make-the-locking-RT-aware.patch
        patch -p1 < ${WORKDIR}/patches/0176-tty-serial-pl011-Make-the-locking-work-on-RT.patch
        patch -p1 < ${WORKDIR}/patches/0177-ARM-vfp-Provide-vfp_lock-for-VFP-locking.patch
        patch -p1 < ${WORKDIR}/patches/0178-ARM-vfp-Use-vfp_lock-in-vfp_sync_hwstate.patch
        patch -p1 < ${WORKDIR}/patches/0179-ARM-vfp-Use-vfp_lock-in-vfp_support_entry.patch
        patch -p1 < ${WORKDIR}/patches/0180-ARM-vfp-Move-sending-signals-outside-of-vfp_lock-ed-.patch
        patch -p1 < ${WORKDIR}/patches/0181-ARM-Allow-to-enable-RT.patch
        patch -p1 < ${WORKDIR}/patches/0182-ARM64-Allow-to-enable-RT.patch
        patch -p1 < ${WORKDIR}/patches/0183-powerpc-traps-Use-PREEMPT_RT.patch
        patch -p1 < ${WORKDIR}/patches/0184-powerpc-pseries-iommu-Use-a-locallock-instead-local_.patch
        patch -p1 < ${WORKDIR}/patches/0185-powerpc-pseries-Select-the-generic-memory-allocator.patch
        patch -p1 < ${WORKDIR}/patches/0186-powerpc-kvm-Disable-in-kernel-MPIC-emulation-for-PRE.patch
        patch -p1 < ${WORKDIR}/patches/0187-powerpc-stackprotector-work-around-stack-guard-init-.patch
        patch -p1 < ${WORKDIR}/patches/0188-POWERPC-Allow-to-enable-RT.patch
        patch -p1 < ${WORKDIR}/patches/0189-RISC-V-Probe-misaligned-access-speed-in-parallel.patch
        patch -p1 < ${WORKDIR}/patches/0190-riscv-add-PREEMPT_AUTO-support.patch
        patch -p1 < ${WORKDIR}/patches/0191-riscv-allow-to-enable-RT.patch
        patch -p1 < ${WORKDIR}/patches/0192-sysfs-Add-sys-kernel-realtime-entry.patch
        patch -p1 < ${WORKDIR}/patches/0193-arch-riscv-check_unaligned_acces-don-t-alloc-page-fo.patch
        patch -p1 < ${WORKDIR}/patches/0194-Revert-preempt-Put-preempt_enable-within-an-instrume.patch
        patch -p1 < ${WORKDIR}/patches/0195-Add-localversion-for-RT-release.patch
        patch -p1 < ${WORKDIR}/patches/0196-Linux-6.6.18-rt23-REBASE.patch
        patch -p1 < ${WORKDIR}/patches/0197-arm-Disable-FAST_GUP-on-PREEMPT_RT-if-HIGHPTE-is-als.patch
        patch -p1 < ${WORKDIR}/patches/0198-printk-nbcon-move-locked_port-flag-to-struct-uart_po.patch
        patch -p1 < ${WORKDIR}/patches/0199-Linux-6.6.22-rt27-REBASE.patch
}
addtask apply after do_unpack before do_compile
